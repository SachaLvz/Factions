package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.struct.Rel;

public class CmdOfficer extends FCommand
{
	
	public CmdOfficer()
	{
		super();
		this.aliases.add("officer");
		
		this.requiredArgs.add("player name");
		//this.optionalArgs.put("", "");
		
		this.permission = Permission.OFFICER.node;
		this.disableOnLock = true;
		
		senderMustBePlayer = false;
		senderMustBeMember = false;
		senderMustBeOfficer = false;
		senderMustBeLeader = false;
	}
	
	@Override
	public void perform()
	{
		FPlayer you = this.argAsBestFPlayerMatch(0);
		if (you == null) return;

		boolean permAny = Permission.OFFICER_ANY.has(sender, false);
		Faction targetFaction = you.getFaction();

		if (targetFaction != myFaction && !permAny)
		{
			msg("%s<b> n'est pas un membre de votre faction.", you.describeTo(fme, true));
			return;
		}
		
		if (fme != null && fme.getRole() != Rel.LEADER && !permAny)
		{
			msg("<b>Vous n'êtes pas le chef de faction.");
			return;
		}

		if (you == fme && !permAny)
		{
			msg("<b>Le joueur cible ne doit pas être toi meme.");
			return;
		}

		if (you.getRole() == Rel.LEADER)
		{
			msg("<b>Le joueur n'est pas le chef. Rétrograde le d'abord.");
			return;
		}

		if (you.getRole() == Rel.OFFICER)
		{
			// Revoke
			you.setRole(Rel.MEMBER);
			targetFaction.msg("%s<i> n'est plus modérateur de votre faction.", you.describeTo(targetFaction, true));
			msg("<i>Vous avez supprimé le statut modérateur de %s<i>.", you.describeTo(fme, true));
		}
		else
		{
			// Give
			you.setRole(Rel.OFFICER);
			targetFaction.msg("%s<i> a été promus modéarateur de votre faction.", you.describeTo(targetFaction, true));
			msg("<i>Vous avez promus %s<i> modérateur.", you.describeTo(fme, true));
		}
	}
	
}
