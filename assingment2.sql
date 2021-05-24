select salesman.name,customer.cust_name,customer.city from salesman inner join customer on salesman.city=customer.city;

select orders.ord_no,orders.purch_amt,customer.cust_name,customer.city from orders
 inner join customer on orders.customer_id=customer.customer_id where orders.purch_amt between 500 and 2000;


 select customer.cust_name as "Customer Name",salesman.salesman_id,salesman.city, salesman.name as "Salesman Name",salesman.commission
  from customer inner join salesman on customer.salesman_id=salesman.salesman_id;

  select customer.customer_id,customer.cust_name,customer.city,customer.grade,salesman.name,salesman.commission from customer inner join salesman on customer.salesman_id=
  salesman.salesman_id where salesman.commission > 0.12;

  select customer.customer_id,customer.cust_name,customer.city,customer.grade,salesman.name,salesman.commission from customer inner join salesman on customer.salesman_id=
  salesman.salesman_id where salesman.commission > 0.12 and customer.city != salesman.city;

  select orders.ord_no,orders.ord_date,orders.purch_amt,salesman.commission,customer.cust_name,salesman.name from orders inner join customer on 
  orders.customer_id=customer.customer_id inner join salesman on  customer.salesman_id=salesman.salesman_id;


  select  orders.salesman_id,orders.customer_id, orders.purch_amt,orders.ord_date,customer.cust_name,customer.city as "Cust_City",customer.grade,
  salesman.name as "Sale_Name",salesman.city as "Sale_city" from orders inner join customer on
   orders.customer_id=customer.customer_id inner join salesman on   orders.salesman_id=salesman.salesman_id and customer.city=salesman.city;

select customer.customer_id,cust_name,customer.city,customer.grade,salesman.salesman_id, salesman.name from
 customer left join salesman on customer.salesman_id=salesman.salesman_id order by customer.customer_id ;

 select customer.customer_id,cust_name,customer.city,customer.grade,salesman.salesman_id, salesman.name from
 customer left join salesman on customer.salesman_id=salesman.salesman_id where customer.grade<300  order by customer.customer_id ;

 select customer.cust_name,customer.city,orders.ord_no,orders.ord_date,orders.purch_amt from customer left join orders on 
 customer.customer_id=orders.customer_id order by orders.ord_date;

 select customer.cust_name,customer.city,orders.ord_no,orders.ord_date,orders.purch_amt,salesman.name,salesman.commission from customer left join orders on 
 customer.customer_id=orders.customer_id left join salesman on  customer.salesman_id=salesman.salesman_id; 
 
 select salesman.salesman_id,salesman.name,salesman.city,salesman.commission ,customer.cust_name,customer.city,customer.grade from customer right join salesman
 on salesman.salesman_id=customer.salesman_id order by salesman.salesman_id;

 select salesman.salesman_id,salesman.name,salesman.city,salesman.commission ,customer.cust_name,customer.city,orders.ord_date,orders.ord_no,orders.purch_amt
    from salesman left join customer on salesman.salesman_id=customer.salesman_id left join orders on customer.customer_id=orders.customer_id;

    select salesman.salesman_id,salesman.name,salesman.city,salesman.commission ,customer.cust_name,customer.city,orders.ord_date,orders.ord_no,orders.purch_amt
     from salesman left join customer on salesman.salesman_id=customer.salesman_id left join orders on customer.customer_id=orders.customer_id
     where orders.purch_amt >2000 and customer.grade is not null;

select customer.cust_name,customer.city,orders.ord_no,orders.ord_date,orders.purch_amt
from customer full  outer join orders on customer.customer_id=orders.customer_id;

select customer.cust_name,customer.city,orders.ord_no,orders.ord_date,orders.purch_amt
from customer full  outer join orders on customer.customer_id=orders.customer_id where customer.grade is not null;

select * from salesman cross join customer;

select * from salesman cross join customer where customer.city is not null;

select * from salesman cross join customer where salesman.city is not null and customer.grade is not null;

select * from salesman cross join customer where salesman.city is not null and 
customer.grade is not null and customer.city!=salesman.city;

select * from item_mast inner join company_mast on item_mast.pro_com=company_mast.com_id;

select item_mast.pro_name,item_mast pro_price,company_mast.com_name from item_mast inner join company_mast on item_mast.pro_com=company_mast.com_id;

select avg(item_mast.pro_price),company_mast.com_name from item_mast inner join 
company_mast on item_mast.pro_com=company_mast.com_id group by company_mast.com_name;

select avg(item_mast.pro_price),company_mast.com_name from item_mast inner join 
company_mast on item_mast.pro_com=company_mast.com_id group by company_mast.com_name;

select avg(item_mast.pro_price),company_mast.com_name from item_mast inner join 
company_mast on item_mast.pro_com=company_mast.com_id group by company_mast.com_name having avg(item_mast.pro_price)>350;

select company_mast.com_name,company_mast.com_id,item_mast.pro_price from company_mast inner join item_mast
on company_mast.com_id=item_mast.pro_com and item_mast.pro_price =(select max(item_mast.pro_price) from item_mast 
where company_mast.com_id=item_mast.pro_com);

select emp_details.emp_idno,emp_details.emp_fname,emp_details.emp_lname,emp_details.emp_dept,emp_department.dpt_name
from emp_details inner join emp_department on emp_details.emp_dept=emp_department.dpt_code;

select emp_details.emp_fname,emp_details.emp_lname,emp_department.dpt_name,emp_department.dpt_allotment 
from emp_details inner join emp_department on emp_details.emp_dept=emp_department.dpt_code;

select emp_details.emp_fname,emp_details.emp_lname,emp_department.dpt_name,emp_department.dpt_allotment 
from emp_details inner join emp_department on emp_details.emp_dept=emp_department.dpt_code
 where emp_department.dpt_allotment>50000;

 select emp_department.dpt_name from emp_details inner join
 emp_department on emp_details.emp_dept=emp_department.dpt_code group by emp_department.dpt_name  having count(emp_department.dpt_name)>2;

