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





#ifndef CSEATRECEIVERPROFILE_HPP_
#define CSEATRECEIVERPROFILE_HPP_

#include <queue>

#include "utils/misc/Logger.hpp"
#include "framework/public/profileLib/profileLib.hpp"
#include "samples/linux/Profiles/ProfileAPI/ISeatProfiles.hpp"


using iviLink::CBuffer;
using iviLink::Channel::tChannelId;

IVILINK_PROFILE_BEGIN

class CSeatReceiverProfile   : public iviLink::Channel::CChannelHandler
                             , public ISeatReceiverProfile
{
   IVILINK_PROFILE_DECLARE
   IVILINK_PROFILE_NAME(SeatReceiverProfile)
   IVILINK_PROFILE_VERSION(1)
   IVILINK_PROFILE_UID(SeatReceiverProfile_UID)
   IVILINK_PROFILE_API_UID(SeatReceiverProfile_PAPI_UID)

   virtual void onEnable();
   virtual void onDisable();

   //from CChannelHandler
   virtual void bufferReceived(const iviLink::Channel::tChannelId channel, iviLink::CBuffer const& buffer);
   virtual void channelDeletedCallback(const UInt32 channel_id);
   virtual void connectionLostCallback();

   explicit CSeatReceiverProfile(iviLink::Profile::IProfileCallbackProxy*);
   virtual ~CSeatReceiverProfile();


   iviLink::Channel::tChannelId                 mChannelID;

   profile_callback_t                          *mpAppCallbacks;
};


#endif // CSEATRECEIVERPROFILE_HPP_