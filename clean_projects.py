import os
import shutil

RAW_PATH = "data/raw_projects"
CLEAN_PATH = "data/clean_projects"

os.makedirs(CLEAN_PATH, exist_ok=True)

for project in os.listdir(RAW_PATH):
    src_project = os.path.join(RAW_PATH, project)
    dst_project = os.path.join(CLEAN_PATH, project)
    os.makedirs(dst_project, exist_ok=True)
    
    for root, _, files in os.walk(src_project):
        for file in files:
            if file.endswith(".java"):
                rel_path = os.path.relpath(root, src_project)
                target_dir = os.path.join(dst_project, rel_path)
                os.makedirs(target_dir, exist_ok=True)
                shutil.copy(os.path.join(root, file), target_dir)

print("Cleaned Java projects ready!")