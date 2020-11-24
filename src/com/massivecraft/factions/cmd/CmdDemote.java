package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Rel;

public class CmdDemote extends FCommand
{
	
	public CmdDemote()
	{
		super();
		this.aliases.add("demote");
		
		this.requiredArgs.add("player name");
		//this.optionalArgs.put("", "");
		
		this.permission = Permission.DEMOTE.node;
		this.disableOnLock = true;
		
		//To demote someone from member -> recruit you must be an officer.
		//To demote someone from officer -> member you must be a leader.
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
			msg("<b>Vous ne pouvez pas vous graduer vous même .");
			return;
		}

		if (you.getRole() == Rel.MEMBER)
		{
			if (!fme.getRole().isAtLeast(Rel.OFFICER)) {
				msg("<b>Vous devez être un modérateur pour graduer un membre.");
				return;
			}
			you.setRole(Rel.RECRUIT);
			myFaction.msg("%s<i> was demoted to being a recruit in your faction.", you.describeTo(myFaction, true));
		}
		else if (you.getRole() == Rel.OFFICER)
		{
			if (!fme.getRole().isAtLeast(Rel.LEADER)) {
				msg("<b>Vous devez être chef pour graduer en tant que membre.");
				return;
			}
			you.setRole(Rel.MEMBER);
			myFaction.msg("%s<i> a été rétrogradé comme membre de votre faction.", you.describeTo(myFaction, true));
		}
	}
	
}
