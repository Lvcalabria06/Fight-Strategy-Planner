🥊 Fight Strategy Planner
📘 Overview

Fight Strategy Planner is a web-based platform built with Spring Boot that empowers fight coaches to manage fighters, create training strategies, analyze performance, and receive AI-powered recommendations for improvement.

The goal is to merge sports management with data-driven insights, helping coaches make smarter training decisions through performance analytics, feedback tracking, and artificial intelligence.

🚀 Features
🧑‍🏫 Coach & Fighter Management

Secure authentication and authorization using Spring Security + JWT.

CRUD operations for fighters and coaches.

Each fighter can be linked to a specific coach.

📋 Training Plans

Create and manage custom training plans for fighters.

Set goals, dates, and notes for each plan.

Automatically generate AI-based recommendations for training improvement using an external API.

💬 Feedback System

Coaches can write textual feedback after training sessions.

Each feedback includes a performance score (1–10).

All feedback is stored and used for trend analysis.

📊 Performance Analytics

Real-time charts and performance comparisons using Spring Data + Chart.js.

Graphs showing evolution in fighter performance (based on feedback scores and training outcomes).

Cached metrics with Spring Cache (Redis) for optimized performance.

🧠 AI Integration

Integration with an AI Recommendation API that suggests personalized training improvements.

Coaches can view generated insights directly inside each training plan.

🧾 Reporting & Exports (coming soon)

Export data to PDF or Excel using Apache POI / iText.

Scheduled reports via Spring Scheduler.
User Stories (Initial Sprint)

As a coach, I want to register and log in securely, so I can manage my fighters.

As a coach, I want to create and assign training plans, so I can track progress.

As a coach, I want the system to generate AI-based recommendations, so I can optimize my strategies.

As a coach, I want to leave textual feedback and rate each fighter’s performance.

As a coach, I want to view performance analytics in charts, so I can visualize evolution over time.

🔐 Security & Authentication

JWT-based authentication for REST API access.

Role-based authorization (Coach, Admin).

Passwords hashed using BCrypt.

🧠 AI Recommendation Example

When creating or updating a training plan, the system sends the plan details (goals, fighting style, recent performance) to an AI API.
The API responds with a short text recommendation such as:

“Focus on leg defense drills this week. Reaction speed improvement recommended based on last 3 fights.”

This recommendation is stored and displayed in the plan details.

🧪 Testing

Unit tests with JUnit 5 and Mockito.

Integration tests for core services and controllers.

📈 Future Improvements

Video upload and technical review system.

Admin dashboard for event and team management.

Advanced analytics with machine learning models.

Integration with real wearable data (heart rate, motion sensors).
