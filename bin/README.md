REST Controllers and Services
=============================
## Overview

In this assignment students are tasked with creating a small RESTful API that simulates a backend for a quiz-like application. Data will be stored in memory and NOT in a database. Students will implement the API from scratch without a skeleton.

### Summary of the API

Each `Quiz` is identified by a unique `name` field. Each `Quiz` contains a collection of `Question` elements. These questions are also uniquely identified by their own `question` field representing the text of the question. Each question contains a collection of `Answer` elements which are uniquely identified by their own `answer` field representing the text of the answer. The answer will also contain a field signifying if it is the correct answer for the question it belongs to.

---

This assignment is intentionally lacking in it's description of required services and entities/models. It is up to the student to decide how to model the requests, responses, and organize the business logic to meet the specified requirements.

### Requirements

You will need to create/implement the following endpoints and their required services

- [ ] `GET quiz`
    - Returns the collection of `Quiz` elements

- [ ] `POST quiz`

    Creates a quiz and adds to collection
    - Returns the `Quiz` that it created

- [ ] `DELETE quiz/{quizName}`

    Deletes the specified quiz from collection
    - Returns the deleted `Quiz`

- [ ] `PATCH quiz/{quizName}/rename/{newName}`

    Rename the specified quiz using the new name given
    - Returns the renamed `Quiz`

- [ ] `GET quiz/{quizName}/random`
    - Returns a random `Question` from the specified quiz

- [ ] `PATCH quiz/{quizName}/add`

    Adds a question to the specified quiz
    - Receives a `Question`
    - Returns the modified `Quiz`

- [ ] `DELETE quiz/{quizName}/delete/{question}`

    Deletes the specified question from the specified quiz
    - Returns the deleted `Question`

- [ ] `POST quiz/grade`


    Grades a quiz on a simple 0-100 scale
    - Receives a `Quiz`
    - Returns a floating-point value representing a simple grade (0-100)

