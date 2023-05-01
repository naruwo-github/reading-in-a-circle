from flask import Flask, request
from flask_restful import Resource, Api
from flask_sqlalchemy import SQLAlchemy
import os

app = Flask(__name__)
api = Api(app)

app.config['SQLALCHEMY_DATABASE_URI'] = f"mysql://{os.environ['DB_USERNAME']}:{os.environ['DB_PASSWORD']}@{os.environ['DB_HOST']}:{os.environ['DB_PORT']}/{os.environ['DB_NAME']}"

db = SQLAlchemy(app)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), nullable=False)

    def __repr__(self):
        return f"<User {self.name}>"


db.create_all()


class UserResource(Resource):
    def get(self, user_id):
        user = User.query.get_or_404(user_id)
        return {"id": user.id, "name": user.name}

    def put(self, user_id):
        user = User.query.get_or_404(user_id)
        user.name = request.form["name"]
        db.session.commit()
        return {"id": user.id, "name": user.name}

    def delete(self, user_id):
        user = User.query.get_or_404(user_id)
        db.session.delete(user)
        db.session.commit()
        return {"result": "success"}

    def post(self):
        name = request.form["name"]
        new_user = User(name=name)
        db.session.add(new_user)
        db.session.commit()
        return {"id": new_user.id, "name": new_user.name}


api.add_resource(UserResource, "/users/<int:user_id>")
api.add_resource(UserResource, "/users/<int:user_id>", endpoint="user_by_id")
api.add_resource(UserResource, "/users", endpoint="user_create")

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5001)
