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
package org.eurekaclinical.user.service.config;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.servlet.ServletContextEvent;

import org.eurekaclinical.common.config.InjectorSupport;
/**
 * Set up the Guice dependency injection engine. Uses three modules:
 * {@link ServletModule} for web related configuration, {@link AppModule}
 * for non-web related configuration, {@link JpaPersistModule} for persistent
 * related configuration
 * 
 * @author miaoai
 */
public class UserConfigListener extends GuiceServletContextListener {
	private static final String JPA_UNIT = "eurekaclinical-user-service-jpa-unit";
	private final UserServiceProperties userServiceProperties = new UserServiceProperties();

	@Override
	protected Injector getInjector() {
		return new InjectorSupport(
				new Module[]{
					new AppModule(),
					new ServletModule(this.userServiceProperties),
					new JpaPersistModule(JPA_UNIT)
				},
				this.userServiceProperties).getInjector();
	}

	@Override
	public void contextDestroyed(ServletContextEvent inServletContextEvent) {
		super.contextDestroyed(inServletContextEvent);
	}    
}
