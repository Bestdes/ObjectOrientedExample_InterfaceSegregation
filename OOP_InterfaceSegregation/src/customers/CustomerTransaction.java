package customers;

import products.Product;
import reports.Reporting;
import accounts.Accounting;

import java.util.Date;
import java.util.List;

/*
Learned: Interface Segregation
Interface Segregation principle states that Modules should not be forced to depend on
behaviours or implementation that it will not use or does not need. This principle
protects the module or client from forced-adoption of behaviours that it should not access and
it protects the programmer from creating degenerate methods which can lead to anti
patterns which is simply just bad coding.

The following code is a program that utilizes and represent the SOLID Object Oriented
Principle of Interface Segregation. Two interfaces were extracted from the
CustomerTransaction class because classes that used the CustomerTransaction class as
composition didn't need all of the behaviours of that class. Thus it was necessary to
segregate the behaviours into two interfaces (Reporting and Accounting). After segregating
the behaviours we then had CustomerTransaction implement those interfaces and then the
classes that composed of the CustomerTransactions were updated then to be composed of
the interfaces that had their relevant behaviours. The net results was that the class,
CustomerTransaction keep it's same implementation and the lower level classes were
able to adopt only their necessary behaviours.
 */

public class CustomerTransaction implements Accounting, Reporting {

    private List<Product> products;
    private Customer customer;

    public CustomerTransaction(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }

    @Override
    public String getName() {
        return customer.getName();
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public String productBreakDown() {
        String reportListing = null;
        for(Product product: products){
            reportListing +=product.getProductName();
            System.out.println(reportListing);
        }
        return reportListing;
    }

    @Override
    public void prepareInvoice() {
        System.out.println("Invoice prepared...");
    }

    @Override
    public void chargeCustomer() {
        System.out.println("Charging customer...");
    }
}
