import os
import pandas as pd
from parser.java_parser import get_java_files, parse_java_file
from features.feature_extractor import extract_class_features, extract_method_features

RAW_PATH = "data/clean_projects"

class_rows = []
method_rows = []

for project in os.listdir(RAW_PATH):
    project_path = os.path.join(RAW_PATH, project)

    java_files = get_java_files(project_path)

    for file in java_files:
        tree = parse_java_file(file)

        if tree is None:
            continue

        with open(file, 'r', encoding='utf-8', errors='ignore') as f:
            code = f.read()

        class_features = extract_class_features(tree, code)
        method_features = extract_method_features(tree, code)

        class_rows.extend(class_features)
        method_rows.extend(method_features)

# Save CSVs
pd.DataFrame(class_rows).to_csv("data/processed/class_features.csv", index=False)
pd.DataFrame(method_rows).to_csv("data/processed/method_features.csv", index=False)

print("Dataset created!")