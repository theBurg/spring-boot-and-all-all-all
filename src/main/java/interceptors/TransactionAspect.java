package interceptors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
class TransactionAspect extends TransactionSynchronizationAdapter {

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void registerTransactionSyncrhonization() {
        TransactionSynchronizationManager.registerSynchronization(this);

    }

    @Override
    public void beforeCommit(boolean readOnly){
        //code
    }

    @Override
    public void afterCompletion(int status) {
        // code
    }
}