package randomObjectPopulate;

import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class RandomObjectFiillerTest {
	
	 @Test  
	  public void test() throws Exception {  
		 TestClass tc;
		 RandomObjectFiller rof = new RandomObjectFiller();
			tc = rof.createAndFill(TestClass.class);
			System.out.println(tc.getIntvar());
			//System.out.println(tc.getListvar());
			System.out.println(tc.getLongvar());
			System.out.println(tc.getStrvar());
			
			assertNotNull(tc);
		 
	    }  

}
