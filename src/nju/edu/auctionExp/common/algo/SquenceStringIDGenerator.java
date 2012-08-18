package nju.edu.auctionExp.common.algo;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

public class SquenceStringIDGenerator extends SequenceStyleGenerator {

	@Override
	public void configure(Type type, Properties params, Dialect dialect)
			throws MappingException {
		type = new IntegerType();
		super.configure(type, params, dialect);
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		return super.generate(session, object).toString();
	}

}
