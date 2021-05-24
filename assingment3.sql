select name from physician where employeeid in ( select undergoes.physician from undergoes
  left join trained_In on undergoes.physician=trained_in.physician and undergoes.procedure=trained_in.treatment
     where treatment is null );

SELECT ph.name AS "Physician",
       pr.name AS "Procedure",
       u.date,
       pt.name AS "Patient"
FROM physician ph,
     undergoes u,
     patient pt,
     PROCEDURE pr
WHERE u.patient = pt.SSN
  AND u.procedure = pr.Code
  AND u.physician = ph.EmployeeID
  AND NOT EXISTS
    ( SELECT *
     FROM trained_in t
     WHERE t.treatment = u.procedure
       AND t.physician = u.physician );


select name , position from physician where employeeid in
    ( select physician from undergoes  where date >
         ( select certificationexpires from trained_in  where trained_in.physician = undergoes.physician
            and trained_in.treatment = undergoes.procedure ) );


select P.Name AS Physician, Pr.Name AS Procedure, U.Date, Pt.Name AS Patient, T.CertificationExpires
  from Physician P, Undergoes U, Patient Pt, Procedure Pr, Trained_In T
  where U.Patient = Pt.SSN  and U.Procedure = Pr.Code
    and U.Physician = P.EmployeeID and Pr.Code = T.Treatment
    and P.EmployeeID = T.Physician and U.Date > T.CertificationExpires;

    SELECT Pt.Name AS Patient, Ph.Name AS Physician, N.Name AS Nurse, A.Start, A.End, A.ExaminationRoom, PhPCP.Name AS PCP
  FROM Patient Pt, Physician Ph, Physician PhPCP, Appointment A LEFT JOIN Nurse N ON A.PrepNurse = N.EmployeeID
 WHERE A.Patient = Pt.SSN
   AND A.Physician = Ph.EmployeeID
   AND Pt.PCP = PhPCP.EmployeeID
   AND A.Physician <> Pt.PCP;

SELECT * FROM Undergoes U
 WHERE Patient <> 
   (
     SELECT Patient FROM Stay S
      WHERE U.Stay = S.StayID
   );

SELECT N.Name FROM Nurse N
 WHERE EmployeeID IN
   (
     SELECT OC.Nurse FROM On_Call OC, Room R
      WHERE OC.BlockFloor = R.BlockFloor
        AND OC.BlockCode = R.BlockCode
        AND R.Number = 123
   );

 SELECT ExaminationRoom, COUNT(AppointmentID) AS Number FROM Appointment
GROUP BY ExaminationRoom;

SELECT Pt.Name, PhPCP.Name FROM Patient Pt, Physician PhPCP
 WHERE Pt.PCP = PhPCP.EmployeeID
   AND EXISTS
       (
         SELECT * FROM Prescribes Pr
          WHERE Pr.Patient = Pt.SSN
            AND Pr.Physician = Pt.PCP
       )
   AND EXISTS
       (
         SELECT * FROM Undergoes U, Procedure Pr
          WHERE U.Procedure = Pr.Code
            AND U.Patient = Pt.SSN
            AND Pr.Cost > 5000
       )
   AND 2 <=
       (
         SELECT COUNT(A.AppointmentID) FROM Appointment A, Nurse N
          WHERE A.PrepNurse = N.EmployeeID
            AND N.Registered = 1
       )
   AND NOT Pt.PCP IN
       (
          SELECT Head FROM Department
       );