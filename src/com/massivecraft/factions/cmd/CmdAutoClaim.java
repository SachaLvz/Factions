package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.FPerm;
import com.massivecraft.factions.struct.Permission;

public class CmdAutoClaim extends FCommand
{
	public CmdAutoClaim()
	{
		super();
		this.aliases.add("autoclaim");
		
		//this.requiredArgs.add("");
		this.optionalArgs.put("faction", "your");
		
		this.permission = Permission.AUTOCLAIM.node;
		this.disableOnLock = true;
		
		senderMustBePlayer = true;
		senderMustBeMember = false;
		senderMustBeOfficer = false;
		senderMustBeLeader = false;
	}

	@Override
	public void perform()
	{
		Faction forFaction = this.argAsFaction(0, myFaction);
		if (forFaction == null || forFaction == fme.getAutoClaimFor())
		{
			fme.setAutoClaimFor(null);
			msg("<i>L'auto claim est désactivé.");
			return;
		}
		
		if ( ! FPerm.TERRITORY.has(fme, forFaction, true)) return;
		
		fme.setAutoClaimFor(forFaction);
		
		msg("<i>L'auto claim est activé et claim le territoire <h>%s<i>.", forFaction.describeTo(fme));
		fme.attemptClaim(forFaction, me.getLocation(), true);
	}
	
}