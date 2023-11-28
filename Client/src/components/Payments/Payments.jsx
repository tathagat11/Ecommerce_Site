import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

function Payments() {
  const { billId } = useParams();
  const [paymentDetails, setPaymentDetails] = useState(null);

  useEffect(() => {
    // Fetch payment details using the billId
    const fetchPaymentDetails = async () => {
      try {
        const url = `http://localhost:8080/api/v1/studentpayments/getpayments/${billId}`;
        const response = await axios.get(url);
        setPaymentDetails(response.data);
        console.log(paymentDetails);
      } catch (error) {
        console.error('Error fetching payment details:', error);
      }
    };

    fetchPaymentDetails();
  }, []);

  return (
    <div className="container">
      <div className="py-4">
        <h2>Payment Details for Bill ID: {billId}</h2>
        {paymentDetails ? (
          <>
            <p>Description: {paymentDetails.description}</p>
            <p>Amount: {paymentDetails.amount}</p>
            {/* Add more payment-related details as needed */}
          </>
        ) : (
          <p>Loading payment details...</p>
        )}
      </div>
    </div>
  );
}

export default Payments;
