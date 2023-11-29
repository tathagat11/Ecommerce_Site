import React, { useEffect, useState } from "react";
import { useUser } from "../Context/UserContext";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";

function Home() {
  const [paidBills, setPaidBills] = useState([]);
  const [unpaidBills, setUnpaidBills] = useState([]);
  const { user } = useUser();
  const { setUserContext } = useUser();
  const navigate = useNavigate();

  useEffect(() => {
    if (user && user.rollNo != null) {
      loadBills();
    }
  }, [user]);

  const loadBills = async () => {
    const url = `http://localhost:8080/api/v1/bills/getbillroll/${user.rollNo}`;
    try {
      const result = await axios.get(url);
      const allBills = result.data;

      // Separate paid and unpaid bills
      const paidBills = allBills.filter((bill) => bill.paid);
      const unpaidBills = allBills.filter((bill) => !bill.paid);

      // Set them in the state
      setPaidBills(paidBills);
      setUnpaidBills(unpaidBills);
    } catch (error) {
      console.error("Error loading bills:", error);
    }
  };

  const handleLogout = () => {
    setUserContext({ rollNo: null, password: null });
    navigate("/");
  };

  return (
    <div className="container">
      <div className="py-4">
        {user && user.rollNo != null ? (
          <>
            <h4>Paid Bills</h4>
            <table className="table table-striped table-hover">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Description</th>
                  <th scope="col">Amount</th>
                  <th scope="col">Bill Date</th>
                  <th scope="col">Deadline</th>
                  <th scope="col">View Bill</th>
                </tr>
              </thead>
              <tbody>
                {paidBills.map((bill, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{bill.description}</td>
                    <td>Rs. {bill.amount}</td>
                    <td>{bill.billDate}</td>
                    <td>{bill.deadline}</td>
                    <td>
                      <Link to={`/payments/${bill.billId}`} state={{ bill }}>
                        <Button className="bg-black border-0 pt-1 pb-1 hover-overlay">
                          View
                        </Button>
                      </Link>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>

            <h4>Unpaid Bills</h4>
            <table className="table table-striped table-hover">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Description</th>
                  <th scope="col">Amount</th>
                  <th scope="col">Bill Date</th>
                  <th scope="col">Deadline</th>
                  <th scope="col">View Bill</th>
                </tr>
              </thead>
              <tbody>
                {unpaidBills.map((bill, index) => (
                  <tr key={index}>
                    <th scope="row">{index + 1}</th>
                    <td>{bill.description}</td>
                    <td>Rs. {bill.amount}</td>
                    <td>{bill.billDate}</td>
                    <td>{bill.deadline}</td>
                    <td>
                      <Link to={`/payments/${bill.billId}`} state={{ bill }}>
                        <Button className="bg-black border-0 pt-1 pb-1 hover-overlay">
                          View
                        </Button>
                      </Link>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>

            <button onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <>
            <p>Please log in to view your bills.</p>
            <Link to="/">
              <Button className="bg-black border-0 ">Login</Button>
            </Link>
          </>
        )}
      </div>
    </div>
  );
}

export default Home;
