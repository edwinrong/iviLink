/*
 *
 * iviLINK SDK, version 1.1.2
 * http://www.ivilink.net
 * Cross Platform Application Communication Stack for In-Vehicle Applications
 *
 * Copyright (C) 2012-2013, Luxoft Professional Corp., member of IBS group
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


#ifndef IVILINK_TESTABLE_CConnectionFinder


class CConnectionFinderTest;

#define IVILINK_TESTABLE_CConnectionFinder \
friend class CConnectionFinderTest; \
public: \
    virtual bool start(); \
    virtual bool stop(); \
    void setReadyTest(CCarrierAdapter* pAdapter); \
	void setState(EState currState);



#endif /* TESTMACROS_HPP_ */
