/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import application.entity.Employee;
import application.entity.Attendance;
import application.entity.SalaryDetails;
import application.forms.Employee.EmployeeSalaryDetails;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jpa.criteria.expression.function.AggregationFunction;

/**
 *
 * @author Malinda
 */
public class EmployeeController extends DbCommon{
    
    public void getAllEmployees(DefaultTableModel dtm){
        List list = null;
        Session session = null;
        Query query = null;
        try{
            session = super.getHibernateUtil().openWritebleDbConnection();
            query = session.createQuery("From Employee Where status = 1 ORDER BY EMPLOYEE_ID");
            list = query.list();
            
            if(!list.isEmpty()){
                Iterator<Employee> itr = list.iterator();
                dtm.setRowCount(0);
                while(itr.hasNext()){
                    Employee employee=(Employee) itr.next();
                    dtm.addRow(new Object[] {employee.getEmployeeId(), employee.getEmployeeName(),employee.getNic()});
                    
                }
            
            }
                   
        }
        catch (Exception ex){
            ex.printStackTrace();
                    
        }
        finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
    
    
    
    }
    
    public Employee findEmployeeById(int id){
        
        Employee employee = null;
        List<Employee> employeeList = null;
        Session session = super.getHibernateUtil().openWritebleDbConnection();
        try{
            Query query = session.createQuery("SELECT s FROM Employee s WHERE EMPLOYEE_ID=:empId");
            query.setParameter("empId", id);
            
            
            employeeList = query.list();
            if(!employeeList.isEmpty()){
                Iterator<Employee> itr = employeeList.iterator();
                while (itr.hasNext()){
                    employee=itr.next();
                }
                    
                   return employee;
            }    
            else{
                JOptionPane.showMessageDialog(null, "is Empty");
            
            }
        
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(employeeList != null){
                employeeList.clear();
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        }
        JOptionPane.showMessageDialog(null, employee);
    return employee;
    }
    
    public void setEmployeeDetails(Employee employee){
       // JOptionPane.showMessageDialog(null, "function :"+employee.getEmployeeId());
        
    }
    
    public Attendance findEmployeeAttendanceById(int Id, String AttDate){
        Attendance attendance = new Attendance();
        List<Attendance> employeeAtteList = null;
        Session session =super.getHibernateUtil().openWritebleDbConnection();
        try{
            Query query = session.createQuery("SELECT s from Attendance s where Employee_Id=:empId AND AttDate=:dDate");
            query.setParameter("dDate",AttDate);
            query.setParameter("empId", Id);
            
            employeeAtteList=query.list();
            JOptionPane.showMessageDialog(null, "qury LIST : "+employeeAtteList);
            JOptionPane.showMessageDialog(null, "LIST  : "+employeeAtteList.size());
            if(!employeeAtteList.isEmpty())
           {
               Iterator<Attendance>itr=employeeAtteList.iterator();
               while(itr.hasNext()){
                   attendance=itr.next();
               }
               return attendance;
           }
            else{
                JOptionPane.showMessageDialog(null, "No Details were found");
            }
            
        
        }
        catch (Exception ex){
            ex.printStackTrace();
            
        }
        finally{
            if(employeeAtteList != null){
                employeeAtteList.clear();
            
            }
            super.getHibernateUtil().closeWritebleDbConnection(session);
        
        }        
    
    return attendance;
    
    }
      
    
        public List getEmployeeBById(int Id){
        Attendance attendance = new Attendance();
        List<Attendance> employeeAtteList = null;
        Session session =super.getHibernateUtil().openWritebleDbConnection();
        
        Query query = session.createQuery("From Attendance where status = 1 AND Main =1 ORDER BY Employee_Id");
           
            List list = query.list();
            employeeAtteList=query.list();
//            JOptionPane.showMessageDialog(null, "qury LIST : "+list);
//            JOptionPane.showMessageDialog(null, "LIST  : "+employeeAtteList.size());
            
            JOptionPane.showMessageDialog(null, "Loaded ");
            super.getHibernateUtil().closeWritebleDbConnection(session);
            return employeeAtteList;
           
    }
        public Long getCount(int eId, int dDate){
                      
            Session session = super.getHibernateUtil().openReadableDbConnection();
           
            Query amount=session.createQuery("SELECT COUNT(Employee_Id) FROM Attendance where MONTH(AttDate) =:Ddate AND Employee_Id=:id");
            amount.setParameter("Ddate",dDate);
            amount.setParameter("id",eId);
           
            Long count = (Long)amount.uniqueResult();
            List list1;
            
            list1=amount.list();
            if (!list1.isEmpty()) {
            
                    
                    return count;
                }
            else{
                JOptionPane.showMessageDialog(null, "NULL");
            }
        return count;
        }
        
        public Float calculateSal (int empId){
            
            Long val;
            Session session = super.getHibernateUtil().openReadableDbConnection();
            //remember to pass the Column value NOT THE COLUMN 
            Query query1=session.createQuery("SELECT basicSal FROM Employee WHERE EMPLOYEE_ID=:empId");
            query1.setParameter("empId",empId);
            
            Float basicSal=(Float)query1.uniqueResult();
            
            Query query2=session.createQuery("SELECT bonus FROM Employee WHERE EMPLOYEE_ID=:empId");
            query2.setParameter("empId",empId);
            Float bonus=(Float)query2.uniqueResult();
            
             /*
            JOptionPane.showMessageDialog(null, "BOUNS"+bonus); 
            
            List<Float> rows=query1.list();
            for (Float row: rows) {
            System.out.println(" ------------------- ");
            //System.out.println("id: " + row[0]);
            System.out.println("Basic Sal: " + rows);
            }*/
            Query query3=session.createQuery("SELECT SUM(timeInMinutes) FROM Attendance WHERE Employee_Id=:empId");
            query3.setParameter("empId",empId);
            Long tot=(Long)query3.uniqueResult();
            
            long dBasicSal=basicSal.longValue();
            long dBonus=bonus.longValue();
            val = tot*(dBasicSal/8)+dBonus;
            Float total=(val.floatValue());
            return total;
            
            
        
        }
        
        public void getSalaryDetailsById(int empId, int year, DefaultTableModel dtm){
            List list = null;
            Session session = null;
            Query query = null;
            try{
                session = super.getHibernateUtil().openWritebleDbConnection();
                query = session.createQuery("From SalaryDetails Where Year=:year AND Employee_ID=:empId");
                query.setParameter("year", year);
                query.setParameter("empId", empId);
                list = query.list();
                
                if(!list.isEmpty()){
                    Iterator<SalaryDetails> itr = list.iterator();
                    dtm.setRowCount(0);
                    while(itr.hasNext()){
                        SalaryDetails sal=(SalaryDetails) itr.next();
                        dtm.addRow(new Object[] {sal.getSalId().getSalYear(), sal.getSalId().getSalMonth(), sal.getSalary(),});
                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            finally{
                if(list != null){
                    list.clear();
                }
                session.close();
            }
        }
        
        
        public void getAllEmployeeAttendance(DefaultTableModel dtm, int dDate, int dMonth){
        List list = null;
        Session session = null;
        Query query = null;
        try{
            session = super.getHibernateUtil().openWritebleDbConnection();
            query = session.createQuery("From Attendance Where status = 1 AND main=0 AND DAY(AttDate)=:Ddate AND MONTH(AttDate)=:Ddate1");
            query.setParameter("Ddate",dDate);
            query.setParameter("Ddate1",dMonth);
            list = query.list();
            
            if(!list.isEmpty()){
                Iterator<Attendance> itr = list.iterator();
                dtm.setRowCount(0);
                while(itr.hasNext()){
                    Attendance attendance=(Attendance) itr.next();
                    dtm.addRow(new Object[] {attendance.getAttId().getEmpId(),attendance.getEmployeeName(),attendance.getEmployeeAttendance(), attendance.getInTime(),attendance.getOutTime()});
                    
                }
            
            }
                   
        }
        catch (Exception ex){
            ex.printStackTrace();
                    
        }
        finally {
            if (list != null) {
                list.clear();
            }
            session.close();
        }
    
    
    
    }
        public int InTimeInMinutes(int H, int M){
            return (H*60)+M;     
        
        }
        
        public int OutTimeInMinutes(int H, int M){
            return (H*60)+M;     
        
        }
        public int CalcTime(int InTime, int OutTime){
         
        return OutTime-InTime;
        
        }
    }
    

