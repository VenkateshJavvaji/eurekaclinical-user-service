/*-
 * #%L
 * Eureka! Clinical User Services
 * %%
 * Copyright (C) 2016 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.eurekaclinical.user.service.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import org.eurekaclinical.user.service.entity.OAuthProviderEntity;

import org.eurekaclinical.user.service.dao.OAuthProviderDao;
/**
 * @author miaoai
 */
@Transactional
@Path("/protected/oauthproviders")
@Produces(MediaType.APPLICATION_JSON)
public class OAuthProviderResource {

	private final OAuthProviderDao oauthProviderDao;

	@Inject
	public OAuthProviderResource (OAuthProviderDao
		oauthProviderDao) {
		this.oauthProviderDao = oauthProviderDao;
	}

	@GET
	public List<OAuthProviderEntity> getAll () {
		return this.oauthProviderDao.getAll();
	}
	
	@GET
	@Path("/{id}")
	public OAuthProviderEntity get (@PathParam("id") Long inId) {
		return this.oauthProviderDao.retrieve(inId);
	}

	@GET
	@Path("/byname/{name}")
	public OAuthProviderEntity getByName (@PathParam("name") String inName) {
		return this.oauthProviderDao.getByName(inName);
	}
	
}
