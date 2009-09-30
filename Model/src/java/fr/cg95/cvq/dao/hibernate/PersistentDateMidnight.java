package fr.cg95.cvq.dao.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.usertype.EnhancedUserType;
import org.joda.time.DateMidnight;

/**
 * Persist {@link org.joda.time.DateMidnight} via Hibernate.
 * Adaptation of {@link org.joda.time.contrib.hibernate.PersistentDateTime}.
 *
 * @author Jean-Sébastien Bour (jsb@zenexity.fr)
 */
public class PersistentDateMidnight implements EnhancedUserType {

    private static final int[] SQL_TYPES = new int[] { Types.TIMESTAMP };

    @Override
    public Object fromXMLString(String string) {
        return new DateMidnight(string);
    }

    @Override
    public String objectToSQLString(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toXMLString(Object object) {
        return object.toString();
    }

    @Override
    public Object assemble(Serializable cached, Object value) {
        return cached;
    }

    @Override
    public Object deepCopy(Object value) {
        if (value == null) {
            return null;
        }
        return new DateMidnight(value);
    }

    @Override
    public Serializable disassemble(Object value) {
        return (Serializable)value;
    }

    @Override
    public boolean equals(Object x, Object y) {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        DateMidnight dmx = (DateMidnight) x;
        DateMidnight dmy = (DateMidnight) y;
        return dmx.equals(dmy);
    }

    @Override
    public int hashCode(Object object) {
        return object.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Object nullSafeGet(
        ResultSet resultSet, String[] strings, Object object)
        throws SQLException {
        return nullSafeGet(resultSet, strings[0]);
    }

    public Object nullSafeGet(ResultSet resultSet, String string)
        throws SQLException {
        Object timestamp = Hibernate.TIMESTAMP.nullSafeGet(resultSet, string);
        if (timestamp == null) {
            return null;
        }
        return new DateMidnight(timestamp);
    }

    @Override
    public void nullSafeSet(
        PreparedStatement preparedStatement, Object value, int index)
        throws SQLException{
        if (value == null) {
            Hibernate.TIMESTAMP.nullSafeSet(preparedStatement, null, index);
        } else {
            Hibernate.TIMESTAMP.nullSafeSet(preparedStatement,
                ((DateMidnight) value).toDate(), index);
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return original;
    }

    @Override
    public Class<?> returnedClass() {
        return DateMidnight.class;
    }

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }
}
