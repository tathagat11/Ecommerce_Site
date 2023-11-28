import { useState } from "react";
import "./Login.css"
import { toast, ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
function Login() {
  const [rollNo, setRollNo] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (e) => {
    
e.preventDefault();

    const url = 'http://localhost:8080/api/v1/students/login';
    const data = {
      rollNo: parseInt(rollNo, 10),
      password: password,
    };
    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });

      if (response.status == 200) {
        console.log("Login successful!");
        toast.success('You have logged in!');
  
      } else {
        console.error(response.status);
        toast.error('Incorrect password/roll number!');
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  return (
    <>
    <ToastContainer 
      position="top-center"
      autoClose={5000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      draggable
      progressBarStyle={{ background: 'blue' }} 
      pauseOnHover
    />
    <div className="Auth-form-container">
      <form className="Auth-form" onSubmit={handleSubmit}>
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>Roll Number</label>
            <input
              type="number"
              className="form-control mt-1"
              placeholder="Enter Roll Number"
              value={rollNo}
              onChange={(e) => setRollNo(e.target.value)}
              required
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary">
              Login
            </button>
          </div>
          <p className="forgot-password text-right mt-2">
            <a href="#">Forgot password?</a>
          </p>
        </div>
      </form>
    </div>
    </>
  );
}

export default Login;
