package serenity;

import net.serenitybdd.junit5.SerenityTest;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import serenity.steps.B20Actions;

@SerenityTest
@Tag("voila")
public class VoilaTest {

    @Steps
    B20Actions b20user;

   @Test
    public void testVolia(){

       //GIVEN
       b20user.expectSomeResult();
       //WHEN
       b20user.preparedSomething();
       //THEN
       b20user.takkeAnAction();


    }
}
