<%-- 
    Document   : thank
    Created on : May 29, 2022, 11:43:25 PM
    Author     : BK COMPUTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;800&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link
            href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
            rel="stylesheet"
            />
        <style>
            body {
                background-image: url("leaf2.jpg");
                font-family: "Raleway";
            }
            img {
                max-width: 100%;
                height: auto;
            }
            .headtext {
                color: #f5f5f5;
                width: 100%;
                text-align: center;
            }
            .center {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            .popup {
                width: 560px;
                height: 470px;
                padding: 30px 25px;
                background-color: #f5f5f5;
                border-radius: 10px;
                box-sizing: border-box;
                z-index: 2;
                text-align: center;
            }

            @media only screen and (max-width: 616px) {
                .headtext {
                    color: #f5f5f5;
                    width: 100%;
                    font-size: 36px;
                    text-align: center;
                }
                .popup {
                    width: 410px;
                    height: 490px;
                    padding: 3px 5px;
                    background-color: #f5f5f5;
                    border-radius: 10px;
                    box-sizing: border-box;
                    z-index: 2;
                    text-align: center;
                }
                .popup .title {
                    margin: 5px 0px;
                    font-size: 10px;
                }
                .popup .description {
                    margin-top: 26px;
                    color: #222;
                    font-size: 6px;
                }
                .popup .dismiss-btn {
                    margin-top: 45px;
                    /* margin-bottom: 20px; */
                }
                .popup .dismiss-btn button {
                    width: 10%;
                    padding: 1px 2px;
                    background-color: #2dbb79;
                    color: #f5f5f5;
                    border: 2px solid #2dbb79;
                    font-size: 26px;
                    font-weight: 800;
                    outline: none;
                    border-radius: 10px;
                }
                .botm {
                    margin-top: 3px;

                    font-size: 16px;
                    color: #19bc87;
                    font-weight: 800;
                }
                .bottomPhoto {
                    padding: 2px;
                    width: 100%;
                    height: 30px;
                    margin-top: 1px;
                    display: flex;
                    justify-content: space-between;
                }
            }
            .popup .title {
                margin: 5px 0px;
                font-size: 50px;
                font-weight: 800;
            }
            .popup .description {
                margin-top: 25px;
                margin-bottom: 20px;
                color: #222;
                font-size: 20px;
                padding: 5px;
            }
            .popup .dismiss-btn {
                margin-top: 55px;
            }
            .popup .dismiss-btn button {
                width: 90%;
                padding: 10px 20px;
                background-color: #2dbb79;
                color: #f5f5f5;
                border: 2px solid #2dbb79;
                font-size: 16px;
                font-weight: 600;
                outline: none;
                border-radius: 10px;
            }
            .botm {
                margin-top: 30px;

                font-size: 36px;
                color: #19bc87;
                font-weight: 800;
            }
            .bottomPhoto {
                width: 100%;
                height: 70px;
                align-items: baseline;

                margin-top: 10px;
                gap: 65px;
                display: flex;
                justify-content: center;
            }

            .online {
                width: 90px;
                text-align: center;
            }
            .online a {
                font-size: 16px;
                color: #19bc87;
                font-weight: 600;
            }
            .tick {
                width: 90px;
                text-align: center;
            }
            .tick a {
                font-size: 16px;
                color: #19bc87;
                font-weight: 600;
            }
            .room {
                text-align: center;
                width: 90px;
            }
            .room a {
                font-size: 16px;
                color: #19bc87;
                font-weight: 600;
            }
        </style>
        <title>Document</title>
    </head>
    <body>
        <div class="headtext">
            <h2>TravelUstad</h2>
        </div>

        <div class="popup center">
            <div class="title">
                <a>Thank You !</a>
            </div>

            <div class="description">
                We will contact you as soon as possible.
                In the worst case, after 3 days our staff has not contacted you,
                please call the hotline for feedback. Sincerely thank!

            </div>
            <a class="botm">Three Steps for Your Holiday</a>
            <div class="bottomPhoto">
                <div class="tick">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCpyVdVfGOU5BxL7qkT0SQSzODYDiRmkeyYQ&usqp=CAU" alt="verification" />
                    <a>Leave information</a>
                </div>

                <div class="room">
                    <img src="https://icon-library.com/images/booking-icon/booking-icon-4.jpg" alt="" />
                    <a>booking confirmation</a>
                </div>

                <div class="online">
                    <img src="img/tick.png" alt="" />
                    <a>enjoy your holiday</a>
                </div>
            </div>

            <div class="dismiss-btn">
                <a href="/web_customer/" class="btn btn-success">Click Here to go homepage</a>
            </div>
        </div>
    </body>
</html>
