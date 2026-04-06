import os
import shutil

RAW_PATH = "data/raw_projects"
CLEAN_PATH = "data/clean_projects"

os.makedirs(CLEAN_PATH, exist_ok=True)

# We only iterate through the immediate items in RAW_PATH (the "Project" folders)
for item in os.listdir(RAW_PATH):
    item_path = os.path.join(RAW_PATH, item)
    
    # Define the destination folder for this project
    # e.g., data/clean_projects/project1
    dst_project_dir = os.path.join(CLEAN_PATH, item)

    # CASE 1: If it's a folder (a project), search inside it
    if os.path.isdir(item_path):
        os.makedirs(dst_project_dir, exist_ok=True)
        
        for root, _, files in os.walk(item_path):
            for file in files:
                if file.endswith(".java"):
                    src_file = os.path.join(root, file)
                    # We flatten it by joining the project dir with ONLY the filename
                    dst_file = os.path.join(dst_project_dir, file)
                    
                    # Optional: Handle duplicate filenames within the same project
                    if os.path.exists(dst_file):
                        base, ext = os.path.splitext(file)
                        dst_file = os.path.join(dst_project_dir, f"{base}_alt{ext}")
                    
                    shutil.copy2(src_file, dst_file)

    # CASE 2: If it's a standalone .java file directly in RAW_PATH
    elif item.endswith(".java"):
        shutil.copy2(item_path, os.path.join(CLEAN_PATH, item))

print(f"Flattening complete! All .java files are now in the top-level of their respective project folders in {CLEAN_PATH}")