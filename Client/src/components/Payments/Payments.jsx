import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import { Button } from "react-bootstrap";
import "./Payments.css"

function Payments() {
  const location = useLocation();
  const { bill } = location.state;
  const [paymentDetails, setPaymentDetails] = useState([]);
  const [pendingAmount, setPendingAmount] = useState(0);
  const [lastDateToPay, setLastDateToPay] = useState("");
  const [deadline, setDeadline] = useState("");
  useEffect(() => {
    // Fetch payment details using the billId
    const fetchPaymentDetails = async () => {
      try {
        const url = `http://localhost:8080/api/v1/studentpayments/getpayments/${bill.billId}`;
        const response = await axios.get(url);
        setPaymentDetails(response.data);
        calculatePendingAmount(response.data);
      } catch (error) {
        console.error("Error fetching payment details:", error);
      }
    };
    // console.log(bill)
    // console.log(paymentDetails)
    fetchPaymentDetails();
  }, [bill]);

  const calculatePendingAmount = (payments) => {
    const totalAmount = bill.amount || 0;

    const totalPaidAmount = payments.reduce(
      (acc, payment) => acc + payment.amount,
      0
    );
    const pendingAmount = totalAmount - totalPaidAmount;
    setPendingAmount(pendingAmount);
    const latestPaymentDate = payments.reduce((latestDate, payment) => {
      return payment.paymentDate > latestDate
        ? payment.paymentDate
        : latestDate;
    }, "");
    const lastDate = new Date(latestPaymentDate);
    lastDate.setDate(lastDate.getDate() + 1);
    setLastDateToPay(lastDate.toDateString());
  };

  const formatDateString = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleDateString("en-GB"); // Change 'en-GB' to your desired locale
  };

  const isLastDatePassed = () => {
    const today = new Date();
    const lastDate = new Date(lastDateToPay);
    return (today > lastDate && bill.paid);
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Payment Details for Bill ID: {bill.billId}</h2>
        {paymentDetails.length > 0 ? (
          <>
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Description</th>
                  <th>Amount</th>
                  <th>Payment Date</th>
                  {/* Add more payment-related details as needed */}
                </tr>
              </thead>
              <tbody>
                {paymentDetails.map((payment, index) => (
                  <tr key={index}>
                    <td>{payment.id}</td>
                    <td>{payment.description}</td>
                    <td>Rs. {payment.amount}</td>
                    <td>{payment.paymentDate}</td>
                    {/* Add more cells for other payment properties */}
                  </tr>
                ))}
              </tbody>
            </table>
            <p>Total Amount: Rs. {bill.amount}</p>
            <p>Pending Amount: Rs. {pendingAmount}</p>
            <p style={{ color: isLastDatePassed() ? "red" : "black" }}>
              Last Date to Pay: {lastDateToPay}
            </p>
            <Button className="print-button" onClick={() => window.print()}>Print Receipt</Button>
          </>
        ) : (
          <div style={{ padding: 10, width: 600, alignSelf: "center" }}>
            <table className="table table-striped">
              <thead>
                <tr>
                <th scope="row">No payments have already been made against this bill.</th>
                </tr>
              </thead>
              <tbody>
              <tr><td>Last date to pay:</td> <td>{formatDateString(bill.deadline)}</td></tr>
              <tr><td>Amount: </td> <td>{bill.amount}</td></tr>
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}

export default Payments;
