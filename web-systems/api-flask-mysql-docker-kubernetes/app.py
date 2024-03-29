from flask import Flask, request
from flask_restful import Resource, Api
from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__)
api = Api(app)
app.config[
    "SQLALCHEMY_DATABASE_URI"
] = f"mysql://{os.environ['DB_USERNAME']}:{os.environ['DB_PASSWORD']}@{os.environ['DB_HOST']}:{os.environ['DB_PORT']}/{os.environ['MYSQL_DATABASE']}"
db = SQLAlchemy(app)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), nullable=False)

    def __repr__(self):
        return f"<User {self.name}>"


class UserResource(Resource):
    def get(self, user_id=None):
        if user_id:
            user = User.query.get_or_404(user_id)
            return {"id": user.id, "name": user.name}
        else:
            return "No user_id provided"

    def put(self, user_id):
        User.query.filter_by(id=user_id).update(dict(name=request.form["name"]))
        db.session.commit()
        return self.get(user_id)

    def delete(self, user_id):
        User.query.filter_by(id=user_id).delete()
        db.session.commit()
        return {"result": "success"}

    def post(self):
        new_user = User(name=request.get_json()["name"])
        db.session.add(new_user)
        db.session.commit()
        return {"id": new_user.id, "name": new_user.name}


api.add_resource(UserResource, "/users", "/users/<int:user_id>")

if __name__ == "__main__":
    db.create_all()
    app.run(debug=True, host="0.0.0.0", port=5001)
