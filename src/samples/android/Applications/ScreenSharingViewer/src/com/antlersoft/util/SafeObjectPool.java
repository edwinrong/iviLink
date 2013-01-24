/* 
 * iviLINK SDK, version 1.1.19
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
 */ 
 
/**
 * Copyright (C) 2009 Michael A. MacDonald
 */
package com.antlersoft.util;

/**
 * Synchronized object pool
 * @author Michael A. MacDonald
 *
 */
public abstract class SafeObjectPool<R> extends ObjectPool<R> {

	/* (non-Javadoc)
	 * @see com.antlersoft.util.ObjectPool#release(com.antlersoft.util.ObjectPool.Entry)
	 */
	@Override
	public synchronized void release(com.antlersoft.util.ObjectPool.Entry<R> entry) {
		super.release(entry);
	}

	/* (non-Javadoc)
	 * @see com.antlersoft.util.ObjectPool#reserve()
	 */
	@Override
	public synchronized com.antlersoft.util.ObjectPool.Entry<R> reserve() {
		return super.reserve();
	}

}