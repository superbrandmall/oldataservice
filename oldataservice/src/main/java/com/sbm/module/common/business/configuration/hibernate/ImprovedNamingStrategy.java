package com.sbm.module.common.business.configuration.hibernate;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.application.configuration.hibernate<br/>
 * File Name:ImprovedNamingStrategy.java<br/>
 * 
 * 作成日 ：2017-9-1 下午5:58:14 <br/>
 * 
 * @author ：junkai.zhang
 */
public class ImprovedNamingStrategy implements PhysicalNamingStrategy {

	@Override
	public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnv) {
		return convert(identifier);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnv) {
		return convert(identifier);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnv) {
		return convert(identifier);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnv) {
		return convert(identifier);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnv) {
		return convert(identifier);
	}

	private Identifier convert(Identifier identifier) {
		if (identifier == null || StringUtils.isBlank(identifier.getText())) {
			return identifier;
		}

		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";
		String newName = identifier.getText().replaceAll(regex, replacement).toLowerCase();
		return Identifier.toIdentifier(newName);
	}

}
