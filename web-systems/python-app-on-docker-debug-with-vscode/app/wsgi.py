from app.app import app as application

application.debug = True

if __name__ == "__main__":
    application.run(host="0.0.0.0", port=5001)
