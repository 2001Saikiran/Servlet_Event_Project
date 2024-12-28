<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Update Event</title>
  <style type="text/css">
    /* General body styling */
    body {
      font-family: 'Verdana', sans-serif;
      background: linear-gradient(to right, #f06, #48c6ef);
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      width: 100vw;
      color: white;
      font-size: 14px;
      overflow: hidden;
    }

    /* Form container */
    fieldset {
      border: none;
      background-color: rgba(255, 255, 255, 0.9);
      padding: 30px;
      border-radius: 15px;
      box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
      width: 300px;
      text-align: center;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    /* Hover effect for fieldset */
    fieldset:hover {
      transform: scale(1.02);
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
    }

    h1 {
      color: #333;
      font-size: 24px;
      font-weight: 600;
      margin-bottom: 20px;
      letter-spacing: 1px;
    }

    /* Label styling */
    label {
      display: block;
      font-size: 12px;
      font-weight: 500;
      color: #333;
      margin-bottom: 5px;
      text-align: left;
      transition: color 0.3s ease;
    }

    /* Input field styling */
    input[type="text"],
    input[type="date"] {
      width: 100%;
      padding: 12px;
      margin-bottom: 15px;
      border: 1px solid #ddd;
      border-radius: 8px;
      font-size: 14px;
      background-color: #f8f8f8;
      box-sizing: border-box;
      transition: background-color 0.3s ease, border-color 0.3s ease;
    }

    /* Hover effect for input fields */
    input[type="text"]:hover,
    input[type="date"]:hover {
      border-color: #80deea;
      background-color: #e0f7fa;
    }

    /* Focus effect for input fields */
    input[type="text"]:focus,
    input[type="date"]:focus {
      background-color: #e0f7fa;
      border-color: #80deea;
      outline: none;
    }

    /* Submit button styling */
    input[type="submit"] {
      width: 70%;
      padding: 12px;
      font-size: 16px;
      color: white;
      background-color: #ff4081;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease, transform 0.3s ease;
    }

    /* Submit button hover effect */
    input[type="submit"]:hover {
      background-color: #f50057;
      transform: scale(1.05);
    }

    /* Event Details button styling */
    a button {
      width: 100%;
      padding: 12px;
      margin-top: 10px;
      font-size: 16px;
      color: white;
      background-color: #3f51b5;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background-color 0.3s ease, transform 0.3s ease;
    }

    /* Hover effect for event details button */
    a button:hover {
      background-color: #303f9f;
      transform: scale(1.05);
    }

    /* Responsive Design for smaller devices */
    @media screen and (max-width: 768px) {
      body {
        font-size: 12px;
      }

      fieldset {
        width: 85%;
      }

      h1 {
        font-size: 20px;
      }

      input[type="submit"] {
        width: 75%;
      }

      a button {
        font-size: 14px;
      }
    }

    @media screen and (max-width: 480px) {
      body {
        font-size: 10px;
      }

      fieldset {
        width: 90%;
        padding: 15px;
      }

      h1 {
        font-size: 18px;
      }

      input[type="submit"] {
        width: 80%;
      }

      a button {
        font-size: 12px;
      }
    }
  </style>
</head>
<body>
  <fieldset>
    <form action="update">
      <h1>Update Event</h1>
      <%
        ResultSet rs = (ResultSet)request.getAttribute("rs");
      %>
      <div class="form-group">
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" placeholder="Enter Id" value="<%= rs.getInt(1) %>" >
      </div>

      <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" placeholder="Enter Title" value="<%= rs.getString(2) %>" >
      </div>

      <div class="form-group">
        <label for="loc">Location:</label>
        <input type="text" id="loc" name="loc" placeholder="Enter Location" value="<%= rs.getString(3) %>" >
      </div>

      <div class="form-group">
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" required value="<%= rs.getString(4) %>"><br>
      </div>

      <div class="form-group">
        <label for="guest">Guest:</label>
        <input type="text" id="guest" name="guest" placeholder="Enter Guest" value="<%= rs.getString(5) %>" >
      </div>

      <input type="submit" value="Submit">
    </form>
  </fieldset>
</body>
</html>