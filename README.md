# STUDENT PLACEMENT PREDICTION APP

This project integrates Machine Learning in an Android Application to predict whether a student will get placed or not.




#### DATASET AND MACHINE LEARNING MODEL:
The data comprises of a small sample dataset comprising 4 attributes - CGPA, IQ, Profile Score and Placed. <br />
Based on CGPA, IQ and Profile Score of a student, Placed is predicted.<br />
RandomForestClassifier is used to make predictions and <accuracy_score> gives an accuracy of 88.34%<br /> <br />
(We can use other algorithms to make prediction- but the main purpose of this project is to integrate ML Model and Android Application. So this accuracy is sufficient for this project.)<br />

#### INTEGRATON PROCESS:
The Machine Learning model is pickled into a .pkl file. The Android application is built using Java and hence needs a bridge to integrate the .pkl file.
This bridging is done by the flask REST API which is then sent to the Android Application in the form of JSON format.<br />

Basically, the integration process goes by the following:
![image](https://user-images.githubusercontent.com/89573580/199936697-a0c26f14-56c2-4805-ad4e-67025afa40f1.png)

#### SOFTWARES/TOOLS USED:
![JUPYTER NOTEBOOK](https://img.shields.io/badge/Jupyter-F37626.svg?&style=for-the-badge&logo=Jupyter&logoColor=white)
![PYCHARM](https://img.shields.io/badge/PyCharm-000000.svg?&style=for-the-badge&logo=PyCharm&logoColor=white)
![CONDA](https://img.shields.io/badge/conda-342B029.svg?&style=for-the-badge&logo=anaconda&logoColor=white)
![FLASK](https://img.shields.io/badge/Flask-000000?style=for-the-badge&logo=flask&logoColor=white)
![HEROKU](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)
![POSTMAN](	https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![ANDROID STUDIO](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)

