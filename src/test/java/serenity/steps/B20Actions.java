package serenity.steps;

import net.thucydides.core.annotations.Step;

public class B20Actions {
    String actor;

    @Step("#actor this is Step 1 name")
    public void preparedSomething(){
        System.out.println("preparing cool stuff");
    }
    @Step("this is step 2 name looks you can name anuthings")
    public void  takkeAnAction(){
        System.out.println("taking some action");
    }
    @Step("here is step 3 name ")
    public void expectSomeResult(){
        System.out.println("expecting some result");
    }
}
