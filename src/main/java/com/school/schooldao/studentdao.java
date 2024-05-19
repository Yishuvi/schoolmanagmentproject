package com.school.schooldao;

import com.school.schoolmanagment.student;
import com.school.util.HibernteUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class studentdao {

    public void saveStudent(String firstName, String lastName, String email){
        Session session = HibernteUtil.getSession();
        Transaction transaction=null;
        try {
            transaction = session.beginTransaction();
            student student = new student();
            student.setFirsName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);

            session.save(student);
            transaction.commit();
            System.out.println("Record inserted sucessessfully");
        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<student> getStudent(){
        Session session= HibernteUtil.getSession();
        Query query=session.createQuery("from student");
        List<student> students=query.list();
        session.close();
        return students;

    }
    public int updatestudent(student s){
        if (s.getId()<=0){
            return 0;
        }
        Session session= HibernteUtil.getSession();
        Transaction tx=session.beginTransaction();
        String hql="update student set firstName=:first_Name, lastName =:last_Name, email=:email where id=:id";

        Query query=session.createQuery(hql);
        query.setParameter("id",s.getId());
        query.setParameter("first_Name",s.getFirsName());
        query.setParameter("last_Name",s.getLastName());
        query.setParameter("email",s.getEmail());

        int rowCount= query.executeUpdate();
        System.out.println("Rows affeected:"+rowCount);
        tx.commit();
        session.close();
        return rowCount;
        }
        public int deleteStudent(int id){
        Session session=HibernteUtil.getSession();
        Transaction tx=session.beginTransaction();
        String hql ="delete from student where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount= query.executeUpdate();

        System.out.println("Row affected: "+rowCount);
        tx.commit();
        session.close();
        return rowCount;
        }
}
