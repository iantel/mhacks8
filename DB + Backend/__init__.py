from flask import Flask
from flask_restful import Resource,Api
from flask_restful import reqparse
from flask.ext.mysql import MySQL

mysql = MySQL()
app = Flask(__name__)


# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'root'
app.config['MYSQL_DATABASE_PASSWORD'] = ''
app.config['MYSQL_DATABASE_DB'] = 'mhacks8'
app.config['MYSQL_DATABASE_HOST'] = 'localhost'

mysql.init_app(app)

api = Api(app)

def addToDatabase():
    conn = mysql.connect()
    cursor = conn.cursor()
    with open("./static/ingred.txt", "r") as f:
        for line in f:
            t_list = eval(line)
            if t_list[4] and (t_list[5] == "MG"):
                cursor.callproc('spAddMedicine', (t_list[2], t_list[4]))
    conn.commit()


class Doctor(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser();
            parser.add_argument('action')
            parser.add_argument('email')
            parser.add_argument('password')
            parser.add_argument('firstname')
            parser.add_argument('lastname')
            parser.add_argument('age')
            parser.add_argument('phone')
            parser.add_argument('address')
            args = parser.parse_args()

            _useraction = args['action']
            _userEmail = args['email']
            _userPassword = args['password']
            _userfirstname = args['firstname']
            _userlastname = args['lastname']
            _userage = args['age']
            _userphone = args['phone']
            _useraddress = args['address']

            if _useraction == 'add':
                conn = mysql.connect()
                cursor = conn.cursor()
                cursor.callproc('spAddDoctor', (_userfirstname, _userlastname, _userage,
                                                _useraddress, _userphone, _userEmail, _userPassword))
                data = cursor.fetchall()
                if len(data) is 0:
                    conn.commit()
                    return {'status': '200', 'data': 'Doctor Creation Successful.'}
                else:
                    return {'status': '300', 'data': str(data[0][0])}

            elif _useraction == 'authenticate':
                conn = mysql.connect()
                cursor = conn.cursor()
                cursor.callproc('sp_authenticateDoctor', (_userEmail))
                data = cursor.fetchall()

                if (len(data) > 0) is 0:
                    conn.commit()
                    return {'status': 'fail', 'data': str(data[0][0])}
                else:
                    return {'status':'fail', 'data':'Incorrect Password'}

            else:
                return {'status': 'fail', 'data': 'Invalid argument for action'}

        except Exception as e:
            return {'status': 'fail', 'data': str(e)}


class Patient(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser();
            parser.add_argument('action')
            parser.add_argument('email')
            parser.add_argument('password')
            parser.add_argument('firstname')
            parser.add_argument('lastname')
            parser.add_argument('age')
            parser.add_argument('phone')
            parser.add_argument('address')
            parser.add_argument('p_a')
            args = parser.parse_args()

            _useraction = args['action']
            _userEmail = args['email']
            _userPassword = args['password']
            _userfirstname = args['firstname']
            _userlastname = args['lastname']
            _userage = args['age']
            _userphone = args['phone']
            _useraddress = args['address']

            if _useraction == 'add':
                conn = mysql.connect()
                cursor = conn.cursor()
                cursor.callproc('spAddDoctor', (_userfirstname, _userlastname, _userage,
                                                _useraddress, _userphone, _userEmail, _userPassword))
                data = cursor.fetchall()
                if len(data) is 0:
                    conn.commit()
                    return {'status': '200', 'data': 'Doctor Creation Successful.'}
                else:
                    return {'status': '300', 'data': str(data[0][0])}

            elif _useraction == 'authenticate':
                conn = mysql.connect()
                cursor = conn.cursor()
                cursor.callproc('sp_authenticateDoctor', (_userEmail))
                data = cursor.fetchall()

                if (len(data) > 0) is 0:
                    conn.commit()
                    return {'status': 'fail', 'data': str(data[0][0])}
                else:
                    return {'status': 'fail', 'data': 'Incorrect Password'}

            else:
                return {'status': 'fail', 'data': 'Invalid argument for action'}

        except Exception as e:
            return {'status': 'fail', 'data': str(e)}





if __name__ == '__main__':
    app.run()
