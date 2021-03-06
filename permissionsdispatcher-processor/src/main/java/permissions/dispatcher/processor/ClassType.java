package permissions.dispatcher.processor;

enum ClassType {
    ACTIVITY("target"),
    V4FRAGMENT("target.getActivity()");

    private final String activity;

    ClassType(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    static ClassType getClassType(String className, TypeResolver resolver) {
        if (resolver.isSubTypeOf(className, ConstantsProvider.ACTIVITY)) {
            return ACTIVITY;
        } else if (resolver.isSubTypeOf(className, ConstantsProvider.V4FRAGMENT)) {
            return V4FRAGMENT;
        }
        return null;
    }

}
