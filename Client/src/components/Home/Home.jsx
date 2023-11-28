import { useEffect, useState } from "react";
import { useUser } from "../Context/UserContext";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";

function Home() {
  const [bills, setBills] = useState([]);
  const { user } = useUser();
  const { setUserContext } = useUser();
  const navigate = useNavigate();

  useEffect(() => {
    if (user && user.rollNo != null) {
      loadBills();
    }
  }, [user]);

  const loadBills = async () => {
    const url = "http://localhost:8080/api/v1/bills/getbillroll/";
    try {
      const result = await axios.get(url + user.rollNo);
      setBills(result.data);
      console.log(result);
    } catch (error) {
      console.error("Error loading bills:", error);
    }
  };
  
  const handleLogout = () => {
    setUserContext({ rollNo: null, password: null });
    navigate('/');
  }

  return (
    <div className="container">
      <div className="py-4">
        {user && user.rollNo != null ? (
          <>
          <table className="table table-striped table-hover">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Description</th>
                <th scope="col">Amount</th>
                <th scope="col">Deadline</th>
                <th scope="col">View Bill</th>
                {/* Add more bill-related columns as needed */}
              </tr>
            </thead>
            <tbody>
              {bills.map((bill, index) => (
                <tr key={index}>
                  <th scope="row">{index + 1}</th>
                  <td>{bill.description}</td>
                  <td>{bill.amount}</td>
                  <td>{bill.deadline}</td>
                  <td>
                    <Link>
                    <Link to={`/payments/${bill.billId}`}>
                        <Button className='bg-black border-0 pt-1 pb-1 hover-overlay'>View</Button>
                      </Link>
                    </Link>
                  </td>
                  {/* Add more cells for other bill properties */}
                </tr>
              ))}
            </tbody>
          </table>
          <button onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <>
            <p>Please log in to view your bills.</p>
            <Link to="/"><Button className="bg-black border-0 ">Login</Button></Link>
          </>
        )}
      </div>
    </div>
  );
}

export default Home;
