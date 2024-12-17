import joblib
import numpy as np
import os

def predict(features):
    try:
        model_path = os.path.join(os.path.dirname(__file__), "model.pkl")
        model = joblib.load(model_path)

        # Thực hiện dự đoán
        ft = np.array([features])
        ft = ft.reshape(1, -1)
        prediction = model.predict_proba(ft)

        return prediction
    except Exception as e:
        return str(e)
