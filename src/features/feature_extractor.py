import javalang

def count_lines(code):
    return len(code.splitlines())


def extract_class_features(tree, code):
    features = []

    for path, node in tree.filter(javalang.tree.ClassDeclaration):
        num_methods = len(node.methods)
        num_fields = len(node.fields)

        class_loc = count_lines(code)

        features.append({
            "class_name": node.name,
            "num_methods": num_methods,
            "num_fields": num_fields,
            "loc": class_loc
        })

    return features


def extract_method_features(tree, code):
    features = []

    for path, node in tree.filter(javalang.tree.MethodDeclaration):
        method_loc = count_lines(str(node))
        num_params = len(node.parameters)

        features.append({
            "method_name": node.name,
            "loc": method_loc,
            "num_params": num_params
        })

    return features