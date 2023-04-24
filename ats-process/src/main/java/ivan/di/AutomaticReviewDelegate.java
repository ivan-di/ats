package ivan.di;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AutomaticReviewDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

    }
}
