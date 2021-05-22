# RandomObjectFiller


Sometimes during testing or any other phase of software development. We need to mock up certain aspects of the code.
This code aims to provide random mock values that can be used at that stage.

If a class is declared and values of those datatype are needed. We can use it the following way: 

    TestClass tc;
    RandomObjectFiller rof = new RandomObjectFiller();
    
    tc = rof.createAndFill(TestClass.class);
    
    System.out.println(tc.getIntvar());
    System.out.println(tc.getLongvar());
    System.out.println(tc.getStrvar());
    
This is particularly useful when we need to mockup API without datasource and need to test the API's
