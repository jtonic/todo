# __BEST PRACTICES__

## Use namespaces:
- __why?__
    - querying by
        - all namespace: `kubectl get svc --all-namespaces`
        - specific namespace: ` kubectl get svc -n todo`
    - delete all from namespaces `kubectl delete all --all -n todo-be`
- see all builtin and defined namespaces

    `kubectl config get-contexts minikube`
- see the current namespace of the kubectl current context

    `kubectl config get-contexts minikube`
- change the current namespace

    `kubectl config set-context $(kubectl config current-context) --namespace=todo`
- create an alias for easy changing of the current namespace

    Add the following line in the `~/.bash_profile`

    `alias kcn='kubectl config set-context $(kubectl config current-context) --namespace '`

## Use labels
- show information about k8s objects using custom columns.
    `kubectl get svc --all-namespaces -o custom-columns=KIND:.kind,NAME:.metadata.name,NS:.metadata.namespace`

## Local development

- use port-forward when the service is not exposed only inside the node

    `kubectl port-forward svc/todo-be -n todo 9092:8081`
