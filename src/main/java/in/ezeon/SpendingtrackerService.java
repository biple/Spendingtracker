
package in.ezeon;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Rukato
 */
public class SpendingtrackerService {
    Repository repo = Repository.getRepository();
    
    
    private Scanner in = new Scanner(System.in);
    private int choice;
    
    public void showMenu(){
        while(true){
            printMenu();
            switch(choice){
                case 1:
                    onAddCategory();
                    pressAnyKeyToContinue();
                    break;
                    
                case 2:
                    onCategoryList();
                    pressAnyKeyToContinue();
                    break;
                
                case 3:
                    onExpenseEntry();
                    pressAnyKeyToContinue();
                    break;    
                
                case 4:
                    onExpenseList();
                    pressAnyKeyToContinue();
                    break;
                
                case 5:
                    onMonthlyExpenseList();
                    pressAnyKeyToContinue();
                    break;
                    
                case 6:
                    onYearlyExpenseList();
                    pressAnyKeyToContinue();
                    break;
                    
                 case 7:
                    onCategorizedExpenses();
                    pressAnyKeyToContinue();
                    break;   
                    
                case 0:
                    onExit();
                    break;    
            }
        }
    }
    
    public void printMenu(){
        System.out.println("-------ExpenseTracker Menu-------");
        System.out.println("1. Add Category");
        System.out.println("2. Category List");
        System.out.println("3. Expense Entry");
        System.out.println("4. Expense List");
        System.out.println("5. Monthly Expense List");
        System.out.println("6. Yearly Expense List");
        System.out.println("7. Categorized Expense List");
        System.out.println("0. Exit");

        System.out.println("----------------------------------");
        System.out.println("Enter your choice: ");
        choice=in.nextInt();
    }
    
    public void pressAnyKeyToContinue(){
        try{
            System.out.println("Press any key to continue...");
            System.in.read();
        }catch (IOException ex){
            ex.printStackTrace();
        } 
    }
    
    public void onAddCategory(){
        in.nextLine();
        System.out.print("Enter Category Name: ");
        String catName=in.nextLine();
        Category cat = new Category(catName);
        repo.catList.add(cat);
        System.out.println("Success: Category Added!");
    }
    
    public void onCategoryList(){
        System.out.println("Category List");
        List<Category> clist = repo.catList;
        for(int i =0; i<clist.size(); i++){
            Category c=clist.get(i);
            System.out.println((i+1)+". "+ c.getName()+", "+ c.getCategoryID());
        }
    }
    public void onExpenseEntry(){
        System.out.println("Enter details for Expense Entry...");
        onCategoryList();
        System.out.print("Choose Category: ");
        int catChoice = in.nextInt();
        Category selectedCat = repo.catList.get(catChoice-1);
        
        System.out.println("Enter Amount: ");
        float amount = in.nextFloat();
        
        System.out.println("Enter Remark: ");
        in.nextLine();
        String remark = in.nextLine();
        
        System.out.println("Enter Date(DD/MM/YYYY): ");
        String dateAsString = in.nextLine();
        Date date=DateUtill.stringToDate(dateAsString);
        
        
        //Adding expense detail in Expense object
        Expense exp=new Expense();
        exp.setCategoryID(selectedCat.getCategoryID());
        exp.setAmount(amount);
        exp.setRemark(remark);
        exp.setDate(date);
        
        //Store expense object in repository
        repo.expList.add(exp);
        System.out.println("Success: Expense is added");
    }
        
    public void onExpenseList(){
        System.out.println("Expense Listing...");
        List<Expense> expList = repo.expList;
        for(int i=0;i<expList.size(); i++){
            Expense exp= expList.get(i);
            String catName = getCategoryNameByID(exp.getCategoryID());
            String dateString = DateUtill.dateToString(exp.getDate());
            System.out.println((i+1)+". "+catName+", "+exp.getAmount()+", "+exp.getRemark()+". "+dateString);
        }
    }
    
    public void onMonthlyExpenseList(){
        
    }
    
    public void onYearlyExpenseList(){
        
    }
    
    public void onCategorizedExpenses(){
        
    }
    
    public void onExit(){
        System.exit(0);
    }
    
    String getCategoryNameByID(Long categoryId){
        for(Category c: repo.catList){
            if(c.getCategoryID().equals(categoryId)){
                return c.getName();
            }
        }
        return null;
    }
}   
    
