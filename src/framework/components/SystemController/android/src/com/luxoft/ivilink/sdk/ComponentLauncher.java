/* 
 * 
 * iviLINK SDK, version 1.1.2
 * http://www.ivilink.net
 * Cross Platform Application Communication Stack for In-Vehicle Applications
 * 
 * Copyright (C) 2012, Luxoft Professional Corp., member of IBS group
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; version 2.1.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * 
 */

package com.luxoft.ivilink.sdk;

import android.util.Log;
/*
 * An instance of this class is passed to System Controller's main,
 * and from there - to utils/android/MakeRequest. Whenever a component 
 * must be launched or reset/shutdown is needed, the answerRequest method is invoked
 */
public class ComponentLauncher {
	enum RequestType {
		eLaunchAgent, 
		eLaunchNegotiator, 
		eLaunchProfileRepository, 
		eLaunchProfileManager, 
		eLaunchApplicationManager, 
		eStartAuth, 
		eIdle, // this means the SSM is in IDLE state and our SDK is fully ready
		eShutdown, 
		eReset
	}
	
	SystemControllerService mService;
	
	ComponentLauncher(SystemControllerService service){
		mService = service;
	}

	final static RequestType[] reqVals = RequestType.values();
	
	void answerRequest(int someRequest){
		Log.v(SystemControllerService.tag, "got request: "+someRequest);
		switch(reqVals[someRequest]){
		case eLaunchAgent:
			mService.launchConnectivityAgent();
			break;
		case eLaunchNegotiator:
			mService.launchChannelSupervisor();
			break;
		case eLaunchProfileRepository:
			mService.launchProfileRepository();
			break;
		case eLaunchProfileManager:
			mService.launchProfileManager();
			break;
		case eLaunchApplicationManager:
			mService.launchApplicationManager();
			break;
		case eStartAuth:
			mService.launchAuthentication();
			break;
		case eIdle:
			mService.allOk();
			break;
		case eShutdown:
			mService.doShutdown();
			break;
		case eReset:
			mService.doReset();
			break;
		}
	}
}
