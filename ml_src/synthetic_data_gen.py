import numpy as np
import pandas as pd
import random

# Setting seed for reproducibility
np.random.seed(42)

# Number of samples
num_samples = 1000

# Generating patient information
ages = np.random.randint(18, 45, num_samples)
weeks_of_pregnancy = np.random.randint(1, 40, num_samples)
previous_pregnancies = np.random.randint(0, 4, num_samples)
pre_existing_conditions = np.random.choice(['None', 'Hypertension', 'Diabetes', 'Both'], num_samples, p=[0.5, 0.25, 0.2, 0.05])
mental_health_history = np.random.choice(['None', 'Anxiety', 'Depression', 'Both'], num_samples, p=[0.7, 0.15, 0.1, 0.05])
dietary_preferences = np.random.choice(['None', 'Vegetarian', 'Vegan', 'Gluten-Free'], num_samples, p=[0.6, 0.2, 0.15, 0.05])

# Generating professional features
def generate_professional_features(num_samples):
    specializations = ['General', 'High-Risk', 'Prenatal Mental Health', 'Postpartum Mental Health', 'Prenatal Nutrition', 'Gestational Diabetes']
    return {
        'Specialization': np.random.choice(specializations, num_samples),
        'Years_of_Experience': np.random.randint(1, 40, num_samples),
        'Patient_Satisfaction_Rating': np.round(np.random.uniform(3, 5, num_samples), 2),
        'Proximity_to_Patient': np.round(np.random.uniform(1, 20, num_samples), 1)  # in kilometers
    }

# Generating data for each professional category
gynecologist_features = generate_professional_features(num_samples)
psychologist_features = generate_professional_features(num_samples)
nutritionist_features = generate_professional_features(num_samples)

# Combining all features into a DataFrame
data = {
    'Age': ages,
    'Weeks_of_Pregnancy': weeks_of_pregnancy,
    'Previous_Pregnancies': previous_pregnancies,
    'Pre_Existing_Conditions': pre_existing_conditions,
    'Mental_Health_History': mental_health_history,
    'Dietary_Preferences': dietary_preferences
}

# Adding gynecologist, psychologist, and nutritionist features
data.update({f'Gynecologist_{key}': value for key, value in gynecologist_features.items()})
data.update({f'Psychologist_{key}': value for key, value in psychologist_features.items()})
data.update({f'Nutritionist_{key}': value for key, value in nutritionist_features.items()})

# Converting to DataFrame
df = pd.DataFrame(data)

# Display the first few rows of the synthetic data
print(df.head())

# Save the synthetic data to a CSV file
df.to_csv('synthetic_pregnancy_recommendations.csv', index=False)
