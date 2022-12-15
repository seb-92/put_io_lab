package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    private IFancyDatabase fancyDatabase;
    private MyDatabase myDatabase;

    @BeforeEach
    void start(){
        this.fancyDatabase = new FancyDatabase();
        this.myDatabase = new MyDatabase();
    }

//    @Test //Zad1
//    void loadExpenses() {
//        //ExpenseRepository expenseRepository = new ExpenseRepository(fancyDatabase);
//        ExpenseRepository expenseRepository = new ExpenseRepository(myDatabase);
//
//        expenseRepository.loadExpenses();
//        List<Expense> expenses = expenseRepository.getExpenses();
//        assertEquals(0, expenses.size());
//    }


//    @Test //Zad2
//    void loadExpenses() {
//        FancyDatabase fDatabase = mock(FancyDatabase.class);
//        ExpenseRepository expenseRepository = new ExpenseRepository(fDatabase);
//        InOrder inOrder = inOrder(fDatabase);
//        expenseRepository.loadExpenses();
//        List<Expense> expenses = expenseRepository.getExpenses();
//
//        verify(fDatabase).close();
//        verify(fDatabase).queryAll();
//        verify(fDatabase).connect();
//
//        inOrder.verify(fDatabase).connect();
//        inOrder.verify(fDatabase).queryAll();
//        inOrder.verify(fDatabase).close();
//
//        assertEquals(0, expenses.size());
//    }

//    @Test //Zad3
//    void loadExpenses() {
//        Expense nExpense = new Expense();
//        nExpense.setAmount(200);
//        nExpense.setCategory("Samochód");
//        nExpense.setTitle("Zakup");
//
//        Expense nExpense2 = new Expense();
//        nExpense.setAmount(200);
//        nExpense.setCategory("Samochód");
//        nExpense.setTitle("Zakup");
//
//        FancyDatabase fDatabase = mock(FancyDatabase.class);
//        ExpenseRepository expenseRepository = new ExpenseRepository(fDatabase);
//
//        for (int i = 0; i < 5; i++) {
//            expenseRepository.addExpense(nExpense);
//        }
//
//        expenseRepository.saveExpenses();
//        expenseRepository.loadExpenses();
//        List<Expense> expenses = expenseRepository.getExpenses();
//        verify(fDatabase, times(5)).persist(nExpense);
//        //verify(fDatabase, times(5)).persist(nExpense2);
//        verify(fDatabase, times(5)).persist(any(Expense.class));
//
//
//        assertEquals(0, expenses.size());
//    }
}
