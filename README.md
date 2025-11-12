🥊 Fight Strategy Planner

A data-driven platform that helps fight coaches plan, analyze, and improve fighter performance using AI and analytics.

📘 Overview

Fight Strategy Planner is a web-based platform built with Spring Boot that empowers fight coaches to:

Manage fighters

Create and track training strategies

Analyze performance metrics

Receive AI-powered recommendations for continuous improvement

The goal is to merge sports management with data-driven insights, helping coaches make smarter training decisions through performance analytics, feedback tracking, and artificial intelligence.

🚀 Core Features
🧑‍🏫 Coach & Fighter Management

🔐 Secure authentication and authorization with Spring Security + JWT

🧾 Full CRUD operations for fighters and coaches

🧩 Each fighter is linked to a specific coach for personalized management

📋 Training Plans

✍️ Create and manage custom training plans

🎯 Set goals, dates, and notes for each plan

🤖 Automatically generate AI-based recommendations for training improvement using an external API

💬 Feedback System

🗣️ Coaches can write textual feedback after training sessions

⭐ Each feedback includes a performance score (1–10)

📈 All feedback is stored and used for trend analysis and performance tracking

📊 Performance Analytics

📉 Real-time charts and performance comparisons using Spring Data + Chart.js

🔍 Graphs showing the evolution in fighter performance (based on feedback scores and training outcomes)

⚡ Cached metrics with Spring Cache (Redis) for optimized performance

🧠 AI Integration

🤝 Integration with an AI Recommendation API that suggests personalized training improvements

💡 Coaches can view generated insights directly within each training plan

🧾 Reporting & Exports (coming soon)

📤 Export data to PDF or Excel using Apache POI / iText

⏰ Automated reports with Spring Scheduler

🧩 User Stories (Initial Sprint)
#	User Story
1️⃣	As a coach, I want to register and log in securely, so I can manage my fighters.
2️⃣	As a coach, I want to create and assign training plans, so I can track progress.
3️⃣	As a coach, I want the system to generate AI-based recommendations, so I can optimize my strategies.
4️⃣	As a coach, I want to leave textual feedback and rate each fighter’s performance.
5️⃣	As a coach, I want to view performance analytics in charts, so I can visualize evolution over time.
🔐 Security & Authentication

🧱 JWT-based authentication for REST API access

🧍‍♂️ Role-based authorization (Coach, Admin)

🔑 Passwords hashed with BCrypt

🧠 AI Recommendation Example

When creating or updating a training plan, the system sends the plan details (goals, fighting style, recent performance) to an AI API.

🧩 Example AI Output:
“Focus on leg defense drills this week. Reaction speed improvement recommended based on last 3 fights.”

This recommendation is automatically stored and displayed within the plan details.

🧪 Testing

🧬 Unit testing with JUnit 5 and Mockito

🔄 Integration testing for core services and controllers

📈 Future Improvements

🎥 Video upload & technical review system

🧭 Admin dashboard for event and team management

📊 Advanced analytics with machine learning models

🥼 Integration with wearable sensors (heart rate, motion tracking, etc.)

▶️ Run Locally
git clone https://github.com/lvcalabria06/fight-strategy-planner.git
cd fight-strategy-planner
mvn spring-boot:run
