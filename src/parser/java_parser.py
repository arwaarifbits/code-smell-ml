import os
import javalang

def get_java_files(project_path):
    java_files = []
    for root, _, files in os.walk(project_path):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))
    return java_files


def parse_java_file(file_path):
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as file:
        content = file.read()
    try:
        tree = javalang.parse.parse(content)
        return tree
    except:
        return None