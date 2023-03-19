package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider2D {

    @Test(dataProvider="UserData")
    void UserNameTest(String userName,String passWord){
        System.out.println("user="+" "+userName+" "+passWord);
    }

    @DataProvider
    public Object[][] UserData(){
        Object[][] data={
                {"Mirzat","970324"},
                {"Xirzat","000518"},
                {"Tumaris","190715"},
                {"Ayjamal","970626"}
        };
        return data;
    }
}
