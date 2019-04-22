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
package org.eurekaclinical.user.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A bean class to hold information related to groups in the system.
 *
 * @author venky
 *
 */
@Entity
@Table(name = "groups")
public class GroupEntity implements org.eurekaclinical.standardapis.entity.GroupEntity {
	/**
	 * The group's unique identifier.
	 */
	@Id
	@SequenceGenerator(name = "GROUP_SEQ_GENERATOR", sequenceName = "GROUP_SEQ",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "GROUP_SEQ_GENERATOR")
	private Long id;
	/**
	 * The group's name.
	 */
	@Column(unique = true, nullable = false)
	private String name;
	/**
	 * Is this group a default group? Default groups are assigned to all new users.
	 */
	private boolean defaultGroup;

	/**
	 * Get the group's identification number.
	 *
	 * @return A {@link Long} representing the group's id.
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the group's identification number.
	 *
	 * @param inId The number representing the group's id.
	 */
	@Override
	public void setId(Long inId) {
		this.id = inId;
	}

	/**
	 * Get the group's name.
	 *
	 * @return A String containing the group's name.
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Set the group's name.
	 *
	 * @param inName A string containing the group's name.
	 */
	@Override
	public void setName(String inName) {
		this.name = inName;
	}

	/**
	 * Is this group a default group?
	 *
	 * @return True if the group is a default group, false otherwise.
	 */
	public boolean isDefaultGroup() {
		return this.defaultGroup;
	}

	/**
	 * Set the group's default flag.
	 *
	 * @param inDefaultGroup True or False, True indicating a default group, False
	 *            indicating a non-default group.
	 */

	public void setDefaultGroup(boolean inDefaultGroup) {
		this.defaultGroup = inDefaultGroup;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof GroupEntity)) return false;

		GroupEntity group = (GroupEntity) o;

		if (defaultGroup != group.defaultGroup) return false;
		if (!id.equals(group.id)) return false;
		if (!name.equals(group.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + (defaultGroup ? 1 : 0);
		return result;
	}
}
