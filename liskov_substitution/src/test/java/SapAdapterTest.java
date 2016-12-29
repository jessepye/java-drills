import com.example.SapAdapter;
import com.sap.SapApi;
import com.sap.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class SapAdapterTest {

    SapAdapter adapter;
    SapApi api = new SapApi();

    @Before
    public void setup() {
        adapter = new SapAdapter(api);
        adapter.addEmployee(new Employee(1, "John", "Oliver"));
        adapter.addEmployee(new Employee(2, "Samantha", "Bee"));
    }

    @Test
    public void canRetrieveEmployees() throws Exception {
        // Exercise
        Object employees = adapter.getEmployeesAsUser();
        Class<?> clazz = employees.getClass();
        int size = (int)clazz.getMethod("size").invoke(employees);
        Employee john = (Employee)clazz.getMethod("get", int.class).invoke(employees, 0);
        Employee samantha = (Employee)clazz.getMethod("get", int.class).invoke(employees, 1);

        // Assert
        Assert.assertTrue("SapAdapter.employees should have two employees", size == 2);
        Assert.assertEquals("John", john.getFirstName());
        Assert.assertEquals("Oliver", john.getLastName());
        Assert.assertEquals("Samantha", samantha.getFirstName());
        Assert.assertEquals("Bee", samantha.getLastName());
    }

    @Test
    public void hrCannotFireEveryone() {
        // Exercise
        Object employees = adapter.getEmployeesAsUser();
        Class<?> clazz = employees.getClass();
        int size = 0;
        Exception ex = null;
        try {
            Optional<Method> clear = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(method -> "clear".equals(method.getName())).findFirst();
            if(clear.isPresent()) {
                clear.get().invoke(employees); // Call the clear() method if it exists
            }
            size = (int)clazz.getMethod("size").invoke(employees);
        } catch (Exception e) {
            ex = e;
        }

        // Assert
        Assert.assertTrue("A runtime exception is an indication of an LSP violation", ex == null);
        Assert.assertTrue("SapAdapter.employees should not be modifiable outside of SapAdapter", size == 2);
    }

    @Test
    public void theCeoCanFireEveryone() throws Exception {
        // Exercise
        Object immutableEmployeeList = adapter.getEmployeesAsUser();
        Class<?> immutableClazz = immutableEmployeeList.getClass();
        Object mutableEmployeeList = adapter.getEmployeesAsCeo();
        Class<?> mutableClazz = mutableEmployeeList.getClass();
        mutableClazz.getMethod("clear").invoke(mutableEmployeeList);

        // Assert
        Assert.assertTrue("Clearing the employee list should fire everyone in SAP", api.getEmployees().size() == 0);
        Assert.assertTrue("Mutable list should extend immutable list", mutableClazz.getSuperclass() == immutableClazz);
    }
}
