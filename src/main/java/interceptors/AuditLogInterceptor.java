package interceptors;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

public class AuditLogInterceptor extends EmptyInterceptor {

    private Long userId;

    public AuditLogInterceptor() {}


    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state,
                          String[] propertyNames, Type[] types) {
        // Need to perform database operations using JPA entity manager
        return false;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id,
                                Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) {
        // other code here
        return false;
    }

    @Override
    public void postFlush(Iterator iterator) throws CallbackException {
        System.out.println("I am on postFlush");
        // other code here
    }
}