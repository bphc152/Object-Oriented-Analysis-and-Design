class DURentSystemTest{
public static void main(String[] args) {
        testcase();
    }
    //* this is a test case
    public static void testcase(){
        int testCount = 0;
        String test;
// TEST: Create new system
        test = "Create new system";
        DURentSystem rs = new DURentSystem();
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Add branches B1, B2, B3
        test = "Add branches B1, B2, B3";
        rs.addBranch("B1", "Address 1", "1111");
        rs.addBranch("B2", "Address 2", "2222");
        rs.addBranch("B3", "Address 3", "3333");
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Set B1, B2 as neighbors
        test = "Set B1, B2 as neighbors";
        rs.setNeighbors("B1", "B2");
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Add rental groups A, B
        test = "Add rental groups A, B";
        rs.addRentalGroup("A", "Compact", 100);
        rs.addRentalGroup("B", "Full Size", 200);
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Add models M1, M2
// GC is the class in which all the global constants (GC) are defined (this is done in the
// interest of simplicity. A more “serious” solution, which we are not pursuing, would use
// enumerated types)
        test = "Add models M1, M2";
        rs.addModel("M1", "Model 1", GC.AUTOMATIC, "A");
        rs.addModel("M2", "Model 2", GC.MANUAL, "B");
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Add cars CAR1, CAR2, CAR3
        test = "Add cars CAR1, CAR2, CAR3";
        rs.addCar("CAR1", "M1", "B1");
        rs.addCar("CAR2", "M1", "B2");
        rs.addCar("CAR3", "M2", "B1");
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Add customers CUST1, CUST2
        test = "Add customers CUST1, CUST2";
        rs.addCustomer("CUST1", "Name 1", "2111", true, false);
        rs.addCustomer("CUST2", "Name 2", "22222", false, false);
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: List available cars at branch B1 for group A
        test = "List available cars at branch B1 for group A";
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n");
        rs.getAvailableCar("B1", "A");
// TEST: List available cars of group A at neighbor branches of B1
        test = "List available cars of group A at neighbor branches of B1";
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n");
        rs.getAvailableCarFromNeighbor("B1", "A");

// TEST: Enter a walk-in rental paid by cash
        test = "Enter a walk-in rental paid by cash";
        rs.addWalkInRental("RENTAL1", 10, 12, "CUST1", "CAR1", "B1", GC.CASH, null);
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
// TEST: Record car return
        test = "Record car return";
        rs.recordCarReturn("RENTAL1", 12, "B2" );
        System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + rs);
    }
}