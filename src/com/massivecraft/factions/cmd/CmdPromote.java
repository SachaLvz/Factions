package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Rel;

public class CmdPromote extends FCommand
{
	
	public CmdPromote()
	{
		super();
		this.aliases.add("promote");
		
		this.requiredArgs.add("player name");
		//this.optionalArgs.put("", "");
		
		this.permission = Permission.PROMOTE.node;
		this.disableOnLock = true;
		
		//To promote someone from recruit -> member you must be an officer.
		//To promote someone from member -> officer you must be a leader.
		//We'll handle this internally
		senderMustBePlayer = true;
		senderMustBeMember = false;
		senderMustBeOfficer = false;
		senderMustBeLeader = false;
	}
	
	@Override
	public void perform()
	{
		FPlayer you = this.argAsBestFPlayerMatch(0);
		if (you == null) return;
		
		if (you.getFaction() != myFaction)
		{
			msg("%s<b> n'est pas un membre de votre faction.", you.describeTo(fme, true));
			return;
		}
		
		if (you == fme)
		{
			msg("<b>Impossible, ça ne peut être vous même.");
			return;
		}

		if (you.getRole() == Rel.RECRUIT)
		{
			if (!fme.getRole().isAtLeast(Rel.OFFICER)) {
				msg("<b>Vous devez être modérateur pour promouvoir quelqu'un.");
				return;
			}
			you.setRole(Rel.MEMBER);
			myFaction.msg("%s<i> a été promus membre de votre faction.", you.describeTo(myFaction, true));
		}
		else if (you.getRole() == Rel.MEMBER)
		{
			if (!fme.getRole().isAtLeast(Rel.LEADER)) {
				msg("<b>Vous devez être chef pour promouvoir un modérateur.");
				return;
			}
			// Give
			you.setRole(Rel.OFFICER);
			myFaction.msg("%s<i> a été promus modérateur de votre faction.", you.describeTo(myFaction, true));
		}
	}
	
}
